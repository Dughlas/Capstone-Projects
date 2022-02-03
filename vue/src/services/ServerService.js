import axios from 'axios';



export default {
    getUserPics(username) {
        return axios.get(`/viewPosts/user/${username}`)
    },
    addNewPic(userPost){
        return axios.post('/addPost', userPost)
    }

}