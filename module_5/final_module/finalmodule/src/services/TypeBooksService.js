import axios from "axios";

export const getAllTypeBooks = async () => {
    try {
        const response = await axios.get('http://localhost:8080/types');
        console.log(response);
        return response.data;
    } catch (error) {
        console.error('Error fetching all type books:', error);
    }
}