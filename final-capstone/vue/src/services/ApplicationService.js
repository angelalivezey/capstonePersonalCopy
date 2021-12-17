import axios from 'axios';

export default {

    // add new Volunteer Form to Database

    submitForm(application) {
        return axios.post("/volunteerapplication", application)
    }

}