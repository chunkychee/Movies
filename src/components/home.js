import React from 'react'
import {Hero} from './hero'


export const Home = ({PropsMovies}) => {
   
   // This useEffect hook will run every time `PropsMovies` changes
    
   return (
    <div>
        <Hero HeroPropsMovies = {PropsMovies}/>
    </div>
   )
}
