import Chart from 'react-apexcharts';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { Temperature } from 'types/temperature';


type SeriesData ={
    name : string;
    data : number[];
}


type ChartData = {
    labels:{
        categories : string[];
    }
    series : SeriesData[];

}

function BarChart(){

    
    const[chartData , setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []                   
            }
        ]

    });

    useEffect(() =>{
        axios.get(`http://localhost:8080/temperatures`)
             .then(response =>{
                console.log(response.data)
                const data = response.data as Temperature[];
                const myLabels = data.map(x => x.temperature)
                const mySeries = data.map(x => x.time)


                setChartData({labels: {
                    categories: myLabels
                },
                series: [
                    {
                        name: "Temperatura",
                        data: mySeries
                    }
                ]

               
        
            })
             })

    } , [])



    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    return(
        <Chart 
            options={{ ...options, xaxis:chartData.labels}}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;