import React, {useEffect, useState} from "react";
import {useLocation, useNavigate} from 'react-router-dom';
import {Formik, Field, ErrorMessage, Form} from 'formik';
import * as Yup from 'yup';
import * as customerService from '../../service/customerService';
import {toast} from 'react-toastify';
import * as customerTypes from '../../service/customerTypeService';


export default function CreateCustomer() {
    const [form, setForm] = useState();
    const {state} = useLocation();
    const navigate = useNavigate();
    const [types, setTypes] = useState([]);

    useEffect(() => {
        getTypes();
    }, []);

    const getTypes = async () => {
        const types = await customerTypes.getAllCustomerTypes();
        setTypes(types);
    }

    useEffect(() => {

        console.log(state);
        if (state) {
            setForm(state)
        } else {
            console.log("aa" + JSON.stringify(types[0]))
            setForm({
                name: "",
                dob: "",
                gender: "Male",
                email: "",
                address: "",
                phone: "",
                idCard: "",
                customerType: JSON.stringify(types[0])
            })
        }
    }, [])

    const validate = {
        name: Yup.string().required("Name cannot be blank !!")
            .matches(/^[A-Z][a-z]+(\s[A-Z][a-z]+)*$/, "The name must be not contain special character anh capitalize the first letter")
            .max(20)
            .min(5),
        dob: Yup.date().required("Day of birth cannot be blank")
            .test('dob', 'Should be greater than 18',
                function (value, ctx) {
                    const valid = new Date().getFullYear() - new Date(value).getFullYear() >= 18;
                    return !valid ? ctx.createError() : valid;
                }),
        idCard: Yup.string().matches(/^\d{9}(\d{3})*$/, "ID card include 9 or 12 numbers")
            .required("ID card not null "),
        phone: Yup.string().matches(/^0\d{9}$/, "phone: 0xxx xxx xxx").required("Not null"),
        email: Yup.string().required("Email not be null"),
        address: Yup.string().required("Address nor null !!!"),
        customerType: Yup.string().required("Not null")
    }
    const submit = async (values) => {
        values.customerType = JSON.parse(values.customerType);
        // const newValues = {...values, customerType: JSON.parse(values.customerType)}
        if (!state) {
            const success = customerService.addNewCustomer(values);
            if (success) {
                toast.success("Customer added ")
            }
        } else {
            const success = customerService.updateCustomer(state.id, values)
            if (success) {
                toast.success("Customer updated ")
            }
        }
        navigate("/customer")
    }

    if (!form) return null;

    return (
        <div className={"create"}>
            <Formik initialValues={form} onSubmit={submit} validationSchema={Yup.object(validate)}>
                <Form>
                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Name</label>
                        <Field type="text" className="form-control" name="name"/>
                        <ErrorMessage name="name" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="dob" className="form-label">Date of birth</label>
                        <Field type="date" className="form-control" name="dob"/>
                        <ErrorMessage name="dob" component="span" className="form-text error"/>
                    </div>

                    <div className="form-check">
                        <Field className="form-check-input" value="Male" type="radio" name="gender" id="gender1"/>
                        <label className="form-check-label" htmlFor="gender1">
                            Male
                        </label>
                    </div>
                    <div className="form-check">
                        <Field className="form-check-input" value="Female" type="radio" name="gender" id="gender2"/>
                        <label className="form-check-label" htmlFor="gender2">
                            Female
                        </label>
                    </div>


                    <div className="mb-3">
                        <label htmlFor="idCard" className="form-label">ID Card</label>
                        <Field type="text" className="form-control" name="idCard"/>
                        <ErrorMessage name="idCard" component="span" className="form-text error"/>
                        <ErrorMessage name="idCard" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="phone" className="form-label">Phone</label>
                        <Field type="text" className="form-control" name="phone"/>
                        <ErrorMessage name="phone" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email</label>
                        <Field type="email" className="form-control" name="email"/>
                        <ErrorMessage name="email" component="span" className="form-text error"/>
                    </div>

                    <div className="mb-3">
                        <label htmlFor="address" className="form-label">Address</label>
                        <Field type="address" className="form-control" name="address"/>
                        <ErrorMessage name="address" component="span" className="form-text error"/>
                    </div>

                    <Field component="select" className="form-select" name="customerType" value={JSON.stringify(form.customerType)}>
                        {/*<option value={JSON.stringify(types[0])} selected disabled >Select customer type</option>*/}
                        {
                            types.map(type => (
                                <option key={type.id} value={JSON.stringify(type)}>{type.name}</option>
                            ))
                        }
                    </Field>
                    <ErrorMessage name="customerType" component="span" className="form-text error"/>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </Form>
            </Formik>
        </div>
    )
}