import React from 'react';
import { useEffect, useState } from 'react';
import { 
  BrowserRouter as Router, 
  Switch,
  Route,
} from 'react-router-dom'

import config from './config.json';
import { ListingView } from './components/ListingView'
import { ProductView } from './components/ProductView'

const App = () => {

  const [ products, setProducts ] = useState([])

  useEffect(() => {
    fetch(config.apiBaseUri + "/products")
      .then(response => response.json())
      .then(response => setProducts(response))
      .catch(console.log)
  }, products )

  return (
    <Router>
      <Switch>
        <Route path="/" exact >
          <ListingView products={products} />
        </Route>
        <Route path="/product/:id" component={ProductView}  />
      </Switch>
    </Router>
  );
}

export default App;
