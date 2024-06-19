import {NotificationContainer, NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import {useNavigate} from 'react-router-dom';
import React, {useEffect, useState} from "react";
import * as Services from "./Service";
import axios from "axios";
import * as Yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";

function CreateService({customView}) {
    //initialization
    const navigate = useNavigate();
    const service = {};
    const [isSubmit, setSubmit] = useState(false);
    let notificationTimeoutId;

    //contains data
    const [serviceSelects, setServiceSelects] = useState({});
    const {service_types, rental_types} = serviceSelects;


    //get data
    useEffect(() => {
        getAllServiceSelects();
    }, []);

    const getAllServiceSelects = async () => {
        try {
            const response = await axios.get('http://localhost:8080/service_selects');
            setServiceSelects(response.data);
        } catch (error) {
            console.error('Error fetching all service selects:', error);
        }
    };

    //result processing
    const filterResult = (values) => {
        //Loại bỏ các thuộc tính không thuộc "House", "Villa" hoặc "Room"
        if (values.service_type === "Room") {
            delete values.room_standard;
            delete values.other_facilities;
            delete values.floors;
            delete values.pool_area;
        } else if (values === "House") {
            delete values.pool_area;
            delete values.free_services;
        } else {
            delete values.free_services;
        }
        delete values.service_type;
    }

    const handleSubmit = async (values) => {
        console.log("HELLO")
        filterResult(values);

        const isSuccess = await Services.addNewService(values);

        if (isSuccess) {
            setSubmit(true);
            console.log('Service added successfully');
            NotificationManager.success('Service added successfully', 'Success', 3000);
            notificationTimeoutId = setTimeout(() => navigate('/service'), 3000);
        }
    };

    useEffect(() => {
        //code run when component mount
        return () => {
            //code run when component unmount
            clearTimeout(notificationTimeoutId);
        };
    }, []);

    //validate data
    const validateService = {
        service_type: Yup.string()
            .required(' (Service type is required)'),
        name: Yup.string()
            .required(' (Name is required)')
            .matches(/^[^\d]+$/, ' (Name cannot contain numbers)'),
        area: Yup.number()
            .min(0, ' (Area cannot be less than 0)')
            .required(' (Area is required)'),
        rental_price: Yup.number()
            .min(0, ' (Rental price cannot be less than 0)')
            .required(' (Area is required)'),
        max_capacity: Yup.number()
            .min(0, ' (Max capacity cannot be less than 0)')
            .required(' (Area is required)'),
        rental_types: Yup.array()
            .min(1,' (Rental types must contain at least one choice)')
            .required(' (Rental types is required)')
        // room_standard: Yup.string()
        //     .required(' (Room standard is required)'),
        // other_facilities: Yup.string()
        //     .required(' (Other facilities is required)'),
        // pool_area: Yup.number()
        //     .min(0, ' (Pool area cannot be less than 0)')
        //     .required(' (Pool area is required)')
    }

    return (
        <div style={customView}>
            <h3>Add New Service</h3>

            <Formik
                initialValues={service} onSubmit={handleSubmit}
                validationSchema={Yup.object(validateService)}
            >
                {({values}) => (
                    <Form>
                        {/* service_type */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Service type</label>
                            <ErrorMessage name="service_type" component="span" className="text-danger" />
                            <Field as="select" className="form-select" name="service_type">
                                <option value="" disabled selected>Select service type</option>
                                {service_types &&
                                service_types.map((serviceType, index) => (
                                    <option key={index} value={serviceType}>
                                        {serviceType}
                                    </option>
                                ))}
                            </Field>
                        </div>

                        {/* name */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Name</label>
                            <ErrorMessage name="name" component="span" className="text-danger"/>
                            <Field type="text" className="form-control" name="name" />
                        </div>

                        {/* area */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Area</label>
                            <ErrorMessage name="area" component="span" className="text-danger"/>
                            <Field type="number" className="form-control" name="area" />
                        </div>

                        {/* rental_price */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Rental price</label>
                            <ErrorMessage name="rental_price" component="span" className="text-danger" />
                            <Field type="number" className="form-control" name="rental_price" />
                        </div>

                        {/* max_capacity */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Max capacity</label>
                            <ErrorMessage name="max_capacity" component="span" className="text-danger"/>
                            <Field type="number" className="form-control" name="max_capacity"/>
                        </div>

                        {/* rental_types */}
                        <div>
                            <label className="fw-bold form-label">Rental types</label>
                            <ErrorMessage name="rental_types" component="span" className="text-danger"/>
                            {rental_types &&
                            rental_types.map((rentalType, index) => (
                                <div key={index} className="mb-3 form-check">
                                    <Field
                                        type="checkbox" className="form-check-input" name="rental_types"
                                        value={rentalType.toLowerCase().replace(/\s/g, '_')}
                                    />
                                    <label className="form-check-label">{rentalType}</label>
                                </div>
                            ))}
                        </div>

                        {(values.service_type === "Villa" || values.service_type === "House") && (
                            <>
                                {/* room_standard */}
                                <div className="mb-3">
                                    <label className="fw-bold form-label">Room standard</label>
                                    <ErrorMessage name="room_standard" component="span" className="text-danger"/>
                                    <Field type="text" className="form-control" name="room_standard"/>
                                </div>

                                {/* other_facilities */}
                                <div className="mb-3">
                                    <label className="fw-bold form-label">Other facility</label>
                                    <ErrorMessage name="other_facilities" component="span" className="text-danger" />
                                    <Field type="text" className="form-control" name="other_facilities" />
                                </div>

                                {/* pool_area */}
                                {values.service_type === "Villa" && (
                                    <div className="mb-3">
                                        <label className="fw-bold form-label">Pool area</label>
                                        <ErrorMessage name="pool_area" component="span" className="text-danger" />
                                        <Field type="number" className="form-control" name="pool_area" />
                                    </div>
                                )}

                                {/* floors */}
                                <div className="mb-3">
                                    <label className="fw-bold form-label">Floor number</label>
                                    <ErrorMessage name="floors" component="span" className="text-danger" />
                                    <Field type="number" className="form-control" name="floors" />
                                </div>
                            </>
                        )}

                        {values.service_type === "Room" && (
                            <>
                                {/* free_services */}
                                <div className="mb-3">
                                    <label className="fw-bold form-label">Free services</label>
                                    <ErrorMessage name="free_services" component="span" className="text-danger" />
                                    <Field type="text" className="form-control" name="free_services" />
                                </div>
                            </>
                        )}

                        {/* image */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Image url</label>
                            <ErrorMessage name="image" component="span" className="text-danger" />
                            <Field type="text" className="form-control" name="image" />
                        </div>

                        {/* radio */}
                        <div className="mb-3">
                            <label className="fw-bold form-label">Premium or Trial</label>
                            <ErrorMessage name="premium_trial" component="span" className="text-danger" />
                            <div className="form-check">
                                <Field type="radio" className="form-check-input"
                                       name="premium_trial" value="Premium" id="premium"
                                />
                                <label className="form-check-label" htmlFor="premium">
                                    Premium
                                </label>
                            </div>
                            <div className="form-check">
                                <Field type="radio" className="form-check-input"
                                       name="premium_trial" value="Trial" id="trial"
                                />
                                <label className="form-check-label" htmlFor="trial">
                                    Trial
                                </label>
                            </div>
                        </div>

                        <button type="submit" className="btn btn-primary" disabled={isSubmit}>Add new service</button>
                    </Form>
                )}
            </Formik>

            <NotificationContainer/>
        </div>
    );
}

export default CreateService;