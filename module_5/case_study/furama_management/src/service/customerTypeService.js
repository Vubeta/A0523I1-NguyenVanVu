import axios from "axios";

export const getAllCustomerTypes = async () => {
    try {
        const response = await axios.get('http://localhost:8000/customerTypes');
        console.log(response);
        return response.data;
    } catch (error) {
        console.error('Error fetching all customer types:', error);
    }
}