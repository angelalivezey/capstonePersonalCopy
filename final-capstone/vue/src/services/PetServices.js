import axios from 'axios';

export default {

    // Gets List of Pets for Home
    displayPets() {
        return axios.get('/pets')
    },

    addPet(newPet) {
        return axios.post('/addnewpet', newPet)
    },

    updatePet(newPet) {
        return axios.put('/updatepetlisting', newPet)
    },


}