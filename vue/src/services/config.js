import axios from 'axios'

export const http = axios.create({
    baseURL: 'https://apirest-products-study.herokuapp.com/api/'
}) 