import axios from "axios";

export const getAllService = async () => {
    try {
        const response = await axios.get('http://localhost:8080/services');
        console.log(response);
        return response.data;
    } catch (error) {
        console.error('Error fetching all services:', error);
    }
}

export const addNewService = async (service) => {
    try {
        await axios.post('http://localhost:8080/services', service);
        return true;
    } catch (error) {
        console.error('Error adding new service:', error);
        return false;
    }
}

export const removeService = async (serviceId) => {
    try {
        await axios.delete(`http://localhost:8080/services/${serviceId}`);
        return true;
    } catch (error) {
        console.error('Error removing service:', error);
        return false;
    }
}

export const updateService = async (serviceId, updateService) => {
    try {
        await axios.put(`http://localhost:8080/services/${serviceId}`, updateService);
        return true;
    } catch (error) {
        console.error('Error updating service:', error);
        return false;
    }
}

export const findById = async (serviceId) => {
    try {
        const response = await axios.get(`http://localhost:8080/services/${serviceId}`);
        return response.data;
    } catch (error) {
        console.error('Error finding service by id:', error);
        console.log(error);
    }
}