import {NotificationContainer, NotificationManager} from 'react-notifications';
import 'react-notifications/lib/notifications.css';
import React, {useState, useEffect} from "react";
import {useNavigate} from "react-router-dom";
import * as Services from "../../service/serviceService";
import Modal from 'react-modal';

function ServiceList({customView}) {
    const navigate = useNavigate();
    const [services, setServices] = useState([]);
    const [nameSearch, setNameSearch] = useState('');
    const [modalIsOpen, setIsOpen] = useState(false);
    const [serviceSelected, setServiceSelected] = useState({});

    const customModalStyle = {
        content: {
            top: '30%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
    };

    const cardImageStyle = {
        width: '100%',
        height: '200px',
        objectFit: 'cover'
    };

    //show service list
    useEffect(() => {
        getAll();
    }, []);

    const getAll = async () => {
        const temp = await Services.getAllService();
        const result = temp.filter(service => service.name.includes(nameSearch));
        setServices(result);
        console.log(services);
    };

    //remove service by id
    const removeService = async () => {
        const isSuccess = await Services.removeService(serviceSelected.id);
        if (isSuccess) {
            NotificationManager.success('Service removed successfully', 'Success', 3000);
        }
        setIsOpen(false);
        getAll();
    }

    //confirm remove modal
    const openModal = (service) => {
        setServiceSelected(service);
        setIsOpen(true);
    }

    //add service
    const handleCreate = () => {
        navigate('/service/add');
    }

    //edit service
    const handleUpdate = (serviceId) => {
        navigate(`/service/update/${serviceId}`);
    }

    //handle
    const handleChange = (event) => {
        setNameSearch(event.target.value);
    }

    const handleSubmit = () => {
        getAll();
    }

    return (
        <div style={customView}>

            <div className="input-group mb-3">
                <input type="text" className="form-control" placeholder="Search by name" onChange={handleChange}/>
                <button className="btn btn-outline-secondary" type="button" onClick={handleSubmit}>Search</button>
            </div>

            <div className="input-group mb-3">
                <span className="input-group-text">Thik thì ghi</span>
                <input type="text" className="form-control" placeholder="Search 1"/>
                <input type="text" className="form-control" placeholder="Search 2"/>
                <button className="btn btn-outline-secondary" type="button" onClick={handleSubmit}>Search</button>
            </div>

            <div className="row row-cols-1 row-cols-md-3 g-4">
                {services.map((service) => (
                    <div className="col">
                        <div className="card" key={service.id}>
                            <img src={service.image} className="card-img-top" alt={`image-${service.id}`}
                                 style={cardImageStyle}/>
                            <div className="card-body">
                                <h5 className="card-title">{service.name}</h5>
                                <p className="card-text">{`Room size: ${service.area}`}</p>
                                <a href="#" className="btn btn-primary" style={{marginRight: '5px'}}>Edit</a>
                                <button onClick={() => openModal(service)} className="btn btn-danger">Delete</button>
                            </div>
                        </div>
                    </div>
                ))}
            </div>

            <Modal
                isOpen={modalIsOpen}
                // onAfterOpen={afterOpenModal}
                onRequestClose={() => setIsOpen(false)}
                style={customModalStyle}
                contentLabel="Example Modal"
            >
                <h2>Delete service</h2>

                <p>Are you sure you want to delete {serviceSelected.name}?</p>
                <button onClick={removeService}>Delete</button>
            </Modal>

            <NotificationContainer/>
        </div>
    );
}

export default ServiceList;