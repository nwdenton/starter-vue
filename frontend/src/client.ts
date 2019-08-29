import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'https://localhost:8080',
});

export default axiosInstance;