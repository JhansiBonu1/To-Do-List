import { useEffect, useState } from "react";
import axios from "axios";
function TaskManager()
{    
    const [isupdate,setisupdate]=useState(false)
    const[id,setid]=useState(null)
    const [data,setdata]=useState([])
    const [form,setform] = useState(
    {
        title: "",
        description: "",
        duDate: ""
    }
    )
    const change=(e)=>
    {
        setform({...form,[e.target.name]:e.target.value});
    }
    const submit=async(e)=>
    {

        e.preventDefault();
        if(!isupdate){

        
        try{
            const res=await axios.post("http://localhost:8082/api/task/add",form,{withCredentials:true})
            console.log(res)
            getData();
            alert(res.data)
            
        }
        catch(err)
        {
            console.log(err)
            alert(err.response.data);
        }
    }
    else{
        try{
            const res = await axios.put(`http://localhost:8082/api/task/update/${id}`,form,{withCredentials:true})
            console.log(res);
            getData();
            alert("updated..");
            setisupdate(false);
            setid(null);
        }
        catch(err)
        {
            console.log(err)
        }
    }
    }

    const getData= async ()=>
    {  
        try
        {
          const res=await axios.get("http://localhost:8082/api/task/getall",{withCredentials:true})
          console.log(res)
          console.log(res.data)
          setdata(res.data)
        }
        catch(err){
            console.log(err)
        }
    }
    useEffect( ()=>
    {
        getData();
    },[]);

    const del= async (id)=>
    {
        try{
          const res=await axios.delete(`http://localhost:8082/api/task/delete/${id}`,{withCredentials:true});
          console.log(res);
          alert("deleted..")
          getData();

        }
        catch(err)
        {
          console.log(err);
        }
    }
    const update = (d)=>
    {   
        
        setform(
            {
                title:d.title,
                description:d.description,
                duDate:d.duDate
            }
        );
        setisupdate(true);
        setid(d.id);
    }

    const toggleComplete = async (task) => {
        try {
            const updatedTask = {
                title: task.title,
                description: task.description,
                duDate: task.duedate,
                completed: !task.completed
            };
            await axios.put(`http://localhost:8082/api/task/update/${task.id}`, updatedTask, { withCredentials: true });
            getData();
        } catch (err) {
            console.log(err);
            alert("Failed to update task status");
        }
    };

    return(
        <>
        <h1>Task Dashboard</h1>
        <form onSubmit={submit} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', margin: '0 auto', maxWidth: '500px' }}>
            <input onChange={change} type="text" name="title" value={form.title} placeholder="Title"/>
            <input onChange={change} type="text" name="description"  value={form.description} placeholder="description"/>
            <input onChange={change} type="date" name="duDate" value={form.duDate} placeholder="duDate"/>
            <button type="submit">{isupdate?"Update Task":"Add Task"}</button>
        </form>
        <table>
            <thead>
                <tr>
                 <th>ID</th>
                 <th>title</th>
                 <th>Description</th>
                 <th>due date</th>
                 <th>status</th>
                 <th>toggle</th>
                </tr>
            </thead>
            <tbody>
                {
                data.map( (d)=>(
                    <tr key={d.id}>
                        <td>{d.id}</td>
                        <td>{d.title}</td>
                        <td>{d.description}</td>
                        <td>{d.duedate}</td>
                        <td>{d.completed?"completed":"incompleted"}</td>
                        <td>
                            <input 
                                type="checkbox" 
                                checked={d.completed} 
                                onChange={() => toggleComplete(d)} 
                            />
                        </td>
                        <button onClick={()=>{del(d.id)}}>Delete</button>
                        <button onClick={()=>{update(d)}}>update</button> 
                    </tr>
                ))
                }
            </tbody>
        </table>
        </>
    )
}
export default TaskManager
