import { useState } from "react"
import axios from 'axios'
import { useNavigate } from "react-router-dom"
function Login()
{
    const nav=useNavigate();
    const [form,setform] = useState(
        {
            email:"",
            password:""
        }
    )
    const change= (e) =>
    {
       setform({...form,[e.target.name]:e.target.value})
    }
    const submit = async (e) =>
    {
       e.preventDefault(); 
       const result=await axios.post('http://localhost:8082/api/user/login',form,{withCredentials:true})
       console.log(result)
       console.log(result.data)
       alert(result.data)
       nav('/taskmanager')
    }
    return(
     <>
     <h1>Welcome to the login page</h1>
     {/* <p>email:{form.email}</p>
     <p>password:{form.password}</p> */}
     <form onSubmit={submit}>
        
        <input type="email" onChange={change} name="email" placeholder="enter your email"/>
        <input type="password" onChange={change} name="password" placeholder="enter password"/>
        
        <button type="submit">Login</button>
     </form>
     </>
    )
}
export default Login