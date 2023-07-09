import 'bootstrap/dist/css/bootstrap.min.css';
import {useState, useEffect} from 'react';
import axios from 'axios';
import {Home} from './components/home';
import {BrowserRouter,Routes, Route} from 'react-router-dom';

function App() {
  const[movies, setMovies] = useState();
  const getMovies = async ()=>{
    try{
      const response = await axios.get("http://localhost:8080/api/v1/movies")
      setMovies(response.data)     
 
    }catch(err){
      console.log(err);
    }
  }

  useEffect(()=>{
    getMovies();
   },[])

   return (
    <div>
      <BrowserRouter>
        <Routes>
            <Route path="/layout"element={<Layout/>}/>
            <Route path="/home"element={<Home PropsMovies = {movies}/>}/> {/*When the '/home' route is active, render the Home component and pass the current value of movies*/}
         </Routes>
       </BrowserRouter>
    </div>
  );
}

export default App;
