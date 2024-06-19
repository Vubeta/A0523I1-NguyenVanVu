import React, {useEffect, useState} from "react";
import {useLocation, useNavigate} from 'react-router-dom';
import {Formik, Field, ErrorMessage, Form} from 'formik';
import * as Yup from 'yup';
import {toast} from 'react-toastify';
import * as bookService from '../services/BookService';
import * as typeBooksService from '../services/TypeBooksService';

export default function Book({customView}) {
    const [form, setForm] = useState();
    const {state} = useLocation();
    const navigate = useNavigate();
    const [typeList, setTypeList] = useState([]);

    useEffect(() => {
        getTypeBooks();
    }, []);

    const getTypeBooks = async () => {
        const temp = await typeBooksService.getAllTypeBooks();
        setTypeList(temp);
    }

    useEffect(() => {
        if (state) {
            setForm(state);
        } else {
            setForm({});
        }
    }, [])

    const validate = {
        bookId: Yup.string().required("Mã sách không được để trống")
            .matches(/^BO-[\d]{4}$/, "Mã sách phải đúng định dạng BO-XXXX với X là các số"),
        name: Yup.string().required("Tên sách không được để trống")
            .max(100, "Tên sách không dài quá 100 ký tự"),
        date: Yup.date().required("Ngày nhập sách không được để trống")
            .max(new Date(), 'Ngày nhập sách không được lớn hơn ngày hiện tại'),
        count: Yup.number().min(1, "Số lượng sách phải là số lớn hơn 0")
    }

    const submit = async (values) => {
        const newRes = {...values, type: JSON.parse(values.type)};
        // values.type = JSON.parse(values.type);
        if (!state) {
            const success = await bookService.addNewBook(newRes);
            if (success) {
                toast.success("Book added ")
            }
        } else {
            const success = await bookService.updateBook(state.id, newRes)
            if (success) {
                toast.success("Book updated ")
            }
        }
        navigate("/")
    }

    if (!form) return null;

    return (
        <div style={customView}>
            <Formik initialValues={form} onSubmit={submit} validationSchema={Yup.object(validate)}>
                <Form>
                    <div className="mb-3">
                        <label htmlFor="bookId" className="form-label">Mã sách</label>
                        <Field type="text" className="form-control" name="bookId"/>
                        <ErrorMessage name="bookId" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Tên sách</label>
                        <Field type="text" className="form-control" name="name"/>
                        <ErrorMessage name="name" component="span" className="form-text error"/>
                    </div>

                    <div>
                        <label htmlFor="type" className="form-label">Thể loại</label>
                        <Field as="select" className="form-select" name="type">
                            {
                                typeList && typeList.map(type => (
                                    <option key={type.id} value={JSON.stringify(type)}>{type.name}</option>
                                ))
                            }
                        </Field>
                        <ErrorMessage name="type" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="date" className="form-label">Ngày nhập sách</label>
                        <Field type="date" className="form-control" name="date"/>
                        <ErrorMessage name="date" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="count" className="form-label">Số lượng</label>
                        <Field type="number" className="form-control" name="count"/>
                        <ErrorMessage name="count" component="span" className="form-text error"/>
                    </div>

                    <button type="submit" className="btn btn-primary">Submit</button>
                </Form>
            </Formik>
        </div>
    );
}