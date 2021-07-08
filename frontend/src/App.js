import './App.css';
import CustomerComponent from './components/CustomerComponent'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { Container } from 'react-bootstrap';
import Header from './components/Header'
import DocumentComponent from './components/DocumentComponent'

function App() {
  return (
    <Router>
      <Header />
      <main className='py-3'>
        <Container>
          <Route path='/' component={CustomerComponent} exact/>
          <Route path='/files' component={DocumentComponent} />
        </Container>
      </main>
    </Router>
          
  );
}

export default App;
