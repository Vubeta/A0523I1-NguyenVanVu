import axios from "axios";

export const getAllCustomer = async () => {
    try {
        const response = await axios.get('http://localhost:8000/customers');
        console.log(response);
        return response.data;
    } catch (error) {
        console.error('Error fetching all customers:', error);
    }
}

export const addNewCustomer = async (customer) => {
    try {
        await axios.post('http://localhost:8000/customers', customer);
        return true;
    } catch (error) {
        console.error('Error adding new customer:', error);
        return false;
    }
}

export const removeCustomer = async (customerId) => {
    try {
        await axios.delete(`http://localhost:8000/customers/${customerId}`);
        return true;
    } catch (error) {
        console.error('Error removing customer:', error);
        return false;
    }
}

export const updateCustomer = async (customerId, updateCustomer) => {
    try {
        await axios.put(`http://localhost:8000/customers/${customerId}`, updateCustomer);
        return true;
    } catch (error) {
        console.error('Error updating customer:', error);
        return false;
    }
}

export const findById = async (customerId) => {
    try {
        const response = await axios.get(`http://localhost:8000/customers/${customerId}`);
        return response.data;
    } catch (error) {
        console.error('Error finding customer by id:', error);
        console.log(error);
    }
}