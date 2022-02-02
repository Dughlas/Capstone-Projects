import axios from 'axios';

export default {
    getUserPics(userId) {
        return axios.get(`/viewPosts/user/${userId}`)
    }

}