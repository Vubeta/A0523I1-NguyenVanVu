import React, {useEffect, useState} from "react";
import {toast} from "react-toastify";
import {useNavigate} from 'react-router-dom';
// import ReactPaginate from 'react-paginate';
import Modal from 'react-modal';

import * as customerService from "../../service/customerService";

export default function CustomerList() {
    const [list, setList] = useState([]);
    const navigate = useNavigate();
    // const [totalPages, setTotalPages] = useState(0);
    const [formSearch, setFormSearch] = useState({
        key: "",
        type: "",
        address: ""
    });

    const [modalIsOpen, setIsOpen] = useState(false);
    const [customerDelete, setCustomerDelete] = useState({});


    const onChangeSearch = (event) => {
        console.log(event.target.value)
        setFormSearch({...formSearch, [event.target.name]: event.target.value})
    }

    useEffect(() => {
        getList();
    }, [formSearch]);

    const getList = async () => {
        const temp = await customerService.getAllCustomer();
        // console.log(formSearch.key)
        const newList = temp.filter(cus => cus.name.toLowerCase().includes(formSearch.key.toLowerCase())
            && cus.address.toLowerCase().includes(formSearch.address.toLowerCase())
            && cus.customerType.name.toLowerCase().includes(formSearch.type))
        setList(newList);
    }

    const deleteCustomer = async (id) => {
        const successs = await customerService.removeCustomer(id)
        console.log(successs)
        if (successs) {
            toast.success("Deleted!");
            getList();
        }
    }


    // const handlePageClick = (event) => {
    //     getList(event.selected + 1)
    // }

    const updateCustomer = (customer) => {
        navigate("/customer/add", {state: customer});
    }

    const customStyles = {
        content: {
            top: '30%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
    };

    //confirm remove modal
    const displayModal = (customer) => {
        setCustomerDelete(customer);
        setIsOpen(true);
    }

    return (
        <div>
            <h1>List Customer:</h1>
            <div className="row g-3 needs-validation">
                <div className="col-md-6">
                    <label htmlFor="nameKey" className="form-label">Find by name</label>
                    <input className="form-control" id="nameKey" name="key" onChange={onChangeSearch}/>
                    <div className="invalid-feedback">
                        Please provide a valid city.
                    </div>
                </div>
                <div className="col-md-3">
                    <label htmlFor="type" className="form-label">Select customer type to filter</label>
                    <select className="form-select" id="type" name="type" onChange={onChangeSearch}>
                        <option value="diamond">Diamond</option>
                        <option value="platinum">Platinum</option>
                        <option value="gold">Gold</option>
                        <option value="silver">Silver</option>
                        <option value="member">Member</option>
                    </select>
                    <div className="invalid-feedback">
                        Please select a valid state.
                    </div>
                </div>
                <div className="col-md-3">
                    <label htmlFor="address" className="form-label">Find by address</label>
                    <input className="form-control" id="address" name="address" onChange={onChangeSearch}/>
                    <div className="invalid-feedback">
                        Please provide a valid zip.
                    </div>
                </div>
            </div>
            <br/>
            <table className="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>DOB</th>
                    <th>Address</th>
                    <th>Type</th>
                    <th>ID card</th>
                    <th>Gender</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    list.map(cus => (
                        <tr key={cus.id}>
                            <td>{cus.name}</td>
                            <td>{cus.phone}</td>
                            <td>{cus.dob}</td>
                            <td>{cus.address}</td>
                            <td>{cus.customerType.name}</td>
                            <td>{cus.idCard}</td>
                            <td>{cus.gender}</td>
                            <td>
                                <button className="btn btn-warning" onClick={() => {
                                    updateCustomer(cus)
                                }}>Edit
                                </button>
                                <button className="btn btn-danger" onClick={() => {
                                    displayModal(cus)
                                }}>Delete
                                </button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>

            </table>
            <Modal
                isOpen={modalIsOpen}
                // onAfterOpen={afterOpenModal}
                onRequestClose={()=> {setIsOpen(false)}}
                style={customStyles}
                contentLabel="Example Modal"
            >
                <h2>Delete customer</h2>

                <p>Are you sure you want to delete {customerDelete.name}?</p>
                <button onClick={deleteCustomer}>Delete</button>
            </Modal>


            <a href="/customer/add" className="btn btn-primary create">Create</a>
            {/*<br/>*/}
            {/*<br/>*/}
            {/*<ReactPaginate*/}
            {/*    breakLabel="..."*/}
            {/*    nextLabel="next >"*/}
            {/*    onPageChange={handlePageClick}*/}
            {/*    pageRangeDisplayed={5}*/}
            {/*    pageCount={totalPages}*/}
            {/*    previousLabel="< previous"*/}
            {/*    renderOnZeroPageCount={null}*/}

            {/*    pageClassName="page-item"*/}
            {/*    pageLinkClassName="page-link"*/}
            {/*    previousClassName="page-item"*/}
            {/*    previousLinkClassName="page-link"*/}
            {/*    nextClassName="page-item"*/}
            {/*    nextLinkClassName="page-link"*/}
            {/*    breakClassName="page-item"*/}
            {/*    breakLinkClassName="page-link"*/}
            {/*    containerClassName="pagination"*/}
            {/*    activeClassName="active"*/}
            {/*/>*/}
        </div>
    )

}