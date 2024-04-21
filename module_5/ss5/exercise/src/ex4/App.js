// import './App.css';
import React, {useState} from 'react';
import {Formik} from 'formik';

function App() {
    const SEX_LIST = [
        {
            label: 'Nam',
            value: 'male'
        },
        {
            label: 'Nữ',
            value: 'female'
        }
    ];

    const REGEX = {
        email: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    };

    const [form, setForm] = useState({healthCard: false});

    function handleChange(event) {

        const value = event.target.type === "checkbox" ? event.target.checked : event.target.value;

        setForm({
            ...form,
            [event.target.name]: value
        });
    }

    function handleValidate() {

        const errors = {};

        if (!form.name) {
            errors.name = "Required";
        }

        if (!form.cmnd) {
            errors.cmnd = "Required";
        }

        if (!form.born) {
            errors.born = "Required";
        } else if (form.born <= 1900) {
            errors.born = "Year of birth is must be greater than 1900";
        }

        if (!form.nationality) {
            errors.nationality = "Required";
        }

        if (!form.company) {
            errors.company = "Required";
        }

        if (!form.province) {
            errors.province = "Required";
        }

        if (!form.district) {
            errors.district = "Required";
        }

        if (!form.ward) {
            errors.ward = "Required";
        }

        if (!form.houseNum) {
            errors.houseNum = "Required";
        }

        if (!form.phone) {
            errors.phone = "Required";
        }

        if (!form.email) {
            errors.email = "Required";
        } else if (!REGEX.email.test(form.email)) {
            errors.email = "Invalid email address";
        }

        return errors;
    }

    function handleSubmit() {
        alert("Khai báo thành công!");
        console.log(form);
    }

    return (
        <>
            <h2>Contact form</h2>
            <Formik
                initialValues={form}
                validate={handleValidate}
                onSubmit={handleSubmit}
            >
                {({errors, handleSubmit}) => (
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label>Họ tên</label>
                            <input
                                className={`custom-input ${errors.name ? "custom-input-error" : ""}`}
                                name="name"
                                value={form.name || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.name}</p>
                        </div>

                        <div>
                            <label>Số hộ chiếu/CMND</label>
                            <input
                                className={`custom-input ${errors.cmnd ? "custom-input-error" : ""}`}
                                name="cmnd"
                                value={form.cmnd || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.cmnd}</p>
                        </div>

                        <div>
                            <label>Năm sinh</label>
                            <input
                                className={`custom-input ${errors.born ? "custom-input-error" : ""}`}
                                type="number"
                                name="born"
                                value={form.born || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.born}</p>
                        </div>

                        <div>
                            <label>Giới tính</label>
                            {SEX_LIST.map((gender) => (
                                <label key={gender.value}>
                                    <input
                                        className="custom-input"
                                        type='radio'
                                        name='gender'
                                        value={gender.value}
                                        checked={form.gender === gender.value}
                                        onChange={handleChange}
                                    />
                                    {gender.label}
                                </label>
                            ))}
                        </div>

                        <div>
                            <label>Quốc tịch</label>
                            <input
                                className={`custom-input ${errors.nationality ? "custom-input-error" : ""}`}
                                name="nationality"
                                value={form.nationality || ""}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.nationality}</p>
                        </div>

                        <div>
                            <label>Công ty làm việc</label>
                            <input
                                className="custom-input"
                                name="company"
                                value={form.company || ""}
                                onChange={handleChange}
                            />
                        </div>

                        <div>
                            <label>Bộ phận làm việc</label>
                            <input
                                className="custom-input"
                                name="department"
                                value={form.department || ""}
                                onChange={handleChange}
                            />
                        </div>

                        <div>
                            <label>
                                Có thẻ bảo hiểm y tế
                                <input
                                    type="checkbox"
                                    name="healthCard"
                                    onChange={handleChange}
                                />
                            </label>
                        </div>

                        <h3>Địa chỉ liên lạc tại Việt Nam</h3>

                        <div>
                            <label>Tỉnh thành</label>
                            <input
                                className={`custom-input ${errors.province ? "custom-input-error" : ""}`}
                                name="province"
                                value={form.province}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.province}</p>
                        </div>

                        <div>
                            <label>Quận/huyện</label>
                            <input
                                className={`custom-input ${errors.district ? "custom-input-error" : ""}`}
                                name="district"
                                value={form.district}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.district}</p>
                        </div>

                        <div>
                            <label>Phường/xã</label>
                            <input
                                className={`custom-input ${errors.ward ? "custom-input-error" : ""}`}
                                name="ward"
                                value={form.ward}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.ward}</p>
                        </div>

                        <div>
                            <label>Số nhà, phố, tổ dân phố/thôn/đội</label>
                            <input
                                className={`custom-input ${errors.houseNum ? "custom-input-error" : ""}`}
                                name="houseNum"
                                value={form.houseNum}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.houseNum}</p>
                        </div>

                        <div>
                            <label>Điện thoại</label>
                            <input
                                className={`custom-input ${errors.phone ? "custom-input-error" : ""}`}
                                name="phone"
                                value={form.phone}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.phone}</p>
                        </div>

                        <div>
                            <label>Email</label>
                            <input
                                className={`custom-input ${errors.email ? "custom-input-error" : ""}`}
                                name="email"
                                value={form.email}
                                onChange={handleChange}
                            />
                            <p className='error'>{errors.email}</p>
                        </div>

                        <button type='submit'>Submit</button>
                    </form>
                )}
            </Formik>
        </>
    );
}

export default App;