import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/mail-analyse'
});

export default API;