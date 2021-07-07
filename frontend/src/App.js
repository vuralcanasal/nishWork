import './App.css';
import CustomerComponent from './components/CustomerComponent'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { Container } from 'react-bootstrap';

function App() {
  return (
    <Router>
      <main className='py-3'>
        <Container>
          <Route path='/' component={CustomerComponent} />
          
        </Container>
      </main>
    </Router>
          
  );
}

export default App;
