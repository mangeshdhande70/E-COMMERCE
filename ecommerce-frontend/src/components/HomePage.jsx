import React from 'react';
import { useState, useEffect } from 'react';

// StickyHeader component
const StickyHeader = () => {
  // State to control whether the header is sticky or not
  const [isSticky, setSticky] = useState(false);

  // Effect to add or remove the 'sticky' class based on scroll position
  useEffect(() => {
    const handleScroll = () => {
      setSticky(window.scrollY > 0);
    };

    // Add the event listener
    window.addEventListener('scroll', handleScroll);

    // Clean up the event listener
    return () => {
      window.removeEventListener('scroll', handleScroll);
    };
  }, []);

  return (
    <header className={`${isSticky ? 'sticky top-0' : ''} bg-white shadow-md z-50`}>
      <nav className="container mx-auto p-4">
        {/* Navigation items */}
        <div className="flex items-center justify-between">
          <div className="logo">
            {/* Logo and home link */}
            <a href="/" className="text-xl font-bold">E-Shop</a>
          </div>
          <div className="navigation">
            {/* Navigation links */}
            <a href="/products" className="p-2">Products</a>
            <a href="/about" className="p-2">About</a>
            <a href="/contact" className="p-2">Contact</a>
          </div>
          <div className="actions">
            {/* Action buttons */}
            <button className="p-2">Login</button>
            <button className="p-2">Cart</button>
          </div>
        </div>
      </nav>
    </header>
  );
};

// HomePage component
const HomePage = () => {
  return (
    <div>
      <StickyHeader />
      {/* Rest of the homepage content */}
      <main className="container mx-auto p-4">
        {/* Your content here */}
      </main>
    </div>
  );
};


export default HomePage;