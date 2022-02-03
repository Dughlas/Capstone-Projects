import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:3000"
});

export default {
    getUserPics(userId) {
        return http.get(`/viewPosts/user/${userId}`)
    },
    addNewPic(userPost){
        return http.post('/addPost', userPost)
    }

}