import { http } from './config'

export default {
    get:() => {
        return http.get('/get/products')
    },
    post:(product) => {
        return http.post('/post/product', product)
    },
    put:(product) =>{
        return http.put('/put/product', product)
    },
    delete:(id) =>{
        return http.delete('/delete/product/' + id)
    }
}