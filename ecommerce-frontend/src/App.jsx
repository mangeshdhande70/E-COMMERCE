import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HomePage from './components/homePage'

function App() {
  return (
    <>
   <div className='flex flex-col items-center space-y-9 justify-center py-9'>
        <h1 className='text-5xl font-bold text-gray-700 dark:text-gray-100'>Welcome to streaming application</h1>
        <HomePage/>
      </div>
    </>
  )
}

export default App
