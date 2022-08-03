import BarChart from "components/BarChart";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
    <NavBar/>
    <div className="container">
      <h2 className="text-primary py-3">Dasboard of temperature</h2>
      <div className="row">
        <div className="row px-3">
            <div className="col-sm-12">
              <BarChart/>
            </div>
        </div>
      </div>
    </div>
    <Footer/>
    </>
  );
}

export default App;
