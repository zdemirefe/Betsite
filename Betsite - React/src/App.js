import { Container, Grid, GridColumn, GridRow } from 'semantic-ui-react';
import './App.css';
import Dashboard from './layouts/Dashboard';
import 'semantic-ui-css/semantic.min.css';
import Navi from './layouts/Navi';
import Categories from './layouts/Categories';

function App() {
  return (
    <div className="App">
      <Navi />
      <Grid>
        <GridRow>
          <GridColumn width={4} style={{ marginTop: '50px' }}>
            <Container className="main">
              <Categories/>
            </Container>
          </GridColumn>
          <GridColumn width={12} style={{ marginTop: '50px' }}>
            <Container className="main">
              <Dashboard/>
            </Container>
          </GridColumn>
        </GridRow>
      </Grid>
    </div>
  );
}

export default App;
