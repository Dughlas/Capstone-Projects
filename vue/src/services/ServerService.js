import axios from 'axios';



export default {
    getUserPics(username) {
        return axios.get(`/viewPosts/user/${username}`)
    },
    addNewPic(userPost){
        return axios.post('/addPost', userPost)
    },
    addNewComment(userComment){
        return axios.post('/addComment', userComment)
    },
    listByUser(username) {
        return axios.get(`/viewPosts/${username}`);
    },
    listAll() {
        return axios.get('/homeFeed')
    },
    listCommentsByPhoto(photoId) {
        return axios.get(`/viewComments/${photoId}`)
    },
    addLike(userLike) {
        return axios.post('/addLike', userLike)
    },
    subtractLike(userLike) {
        return axios.delete( '/removeLike', {data: userLike})
    },
    likeCount(photoId) {
        return axios.get(`/countLike/${photoId}`)
    },
    addToFavorites(favorite) {
        return axios.post(`addToFavorites`, favorite)
    },
    getLikedStatus() {
        return axios.get('/isItLiked')
    }

}