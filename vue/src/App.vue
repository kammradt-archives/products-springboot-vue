<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Vue.js - Products</a>
      </div>
    </nav>
    <div class="container">
      <form @submit.prevent="save()">
          <label>Name</label>
          <input v-model="product.name" type="text" placeholder="Name">
          <label>Quantity</label>
          <input v-model="product.quantity" type="number" placeholder="Quantity">
          <label>Description</label>
          <input v-model="product.description" type="text" placeholder="Description">
          <label>Price</label>
          <input v-model="product.price" type="number" placeholder="Price">
          
          <button class="waves-effect waves-light btn-small">Save<i class="material-icons left">save</i></button>
      </form>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Options</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="product in products" :key="product.id">
            <td>{{ product.name}}</td>
            <td>{{ product.description}}</td>
            <td>{{ product.quantity }}</td>
            <td>{{ product.price }}</td>
            <td>
              <button @click="update(product)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="del(product.id)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>
          </tr>
        </tbody>     
      </table>
    </div>
  </div>
</template>

<script>
import Product from './services/products'

export default {
  data(){
    return{
      
      products: [],
      product: {
        id: '',
        name: null,
        description: null,
        quantity: null,
        price: null,
      }
    }
  },
  mounted(){
    this.get()
  },
  methods:{
    save(){
      if(this.product.id){
        if (this.product.name && this.product.description && this.product.quantity && this.product.price) {
          Product.put(this.product).then(resp => {
            this.product = {}
            alert('Updated!')
            this.get()
          }).catch(e => {
            console.log(e.data.errors)
          })
        } else {
          alert('Fill all fields!')
        }

      } else {
        if (this.product.name && this.product.description && this.product.quantity && this.product.price) {
          Product.post(this.product).then(resp => {
            this.product = {}
            alert('Saved!')
            this.get()
          }).catch(e => {
            console.log(e.data.errors)
          })
        } else {
          alert('Fill all fields!')
        }
      }
    },
    get(){
      Product.get().then(resp =>{
      this.products = resp.data
     })
    },
    update(product){
      this.product = product
    },
    del(id){
      if (confirm('Delete?')) {
        Product.delete(id).then(resp => {
          alert('Deleted!')
          this.get()
        }).catch(e => {
          console.log(e.data)
        })
      }
    }
  }
}
</script>
