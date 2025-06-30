import { Link } from "react-router-dom"
function Home(){
    return(
        <>
        <h1>welcome to home page</h1>
        <Link to="/register">register here</Link><br/>
        <Link to="/login">Login here</Link>
        </>
    )
}
export default Home