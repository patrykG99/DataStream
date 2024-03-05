import * as d3 from 'd3';
import { useEffect, useRef, useState } from "react";

export default function ChartComponent() {
    const chartRef = useRef(null);
    const [data, setData] = useState([]);

    useEffect(() => {
        const apiEndpoint = 'http://localhost:8080/api/messages';
        fetch(apiEndpoint)
            .then(response => response.json())
            .then(dataArray => {
                const parsedData = dataArray.map(item => JSON.parse(item));
                const lastTen = parsedData.slice(-10);
                setData(lastTen);
            })
            .catch(error => console.error('Error fetching data:', error));

    }, []);

    useEffect(() => {
        if (data.length === 0) {
            return;
        }
        console.log(data)
        const width = 640;
        const height = 400;
        const marginTop = 20;
        const marginRight = 20;
        const marginBottom = 30;
        const marginLeft = 40;


        const x = d3.scaleLinear()
            .domain([0, data.length - 1])
            .range([marginLeft, width - marginRight]);

        const yMax = d3.max(data, d => d.maxPrice);
        const yMin = d3.min(data, d => d.maxPrice)
        const y = d3.scaleLinear()
            .domain([yMin, yMax + (yMax * 0.1)])
            .range([height - marginBottom, marginTop]);


        d3.select(chartRef.current).selectAll("*").remove();

        const svg = d3.select(chartRef.current)
            .append("svg")
            .attr("width", width)
            .attr("height", height);


        svg.append("g")
            .attr("transform", `translate(0,${height - marginBottom})`)
            .call(d3.axisBottom(x).ticks(data.length));


        svg.append("g")
            .attr("transform", `translate(${marginLeft},0)`)
            .call(d3.axisLeft(y).tickFormat(d3.format(".2f")));


        const line = d3.line()
            .x((_, i) => x(i))
            .y(d => y(d.maxPrice));


        svg.append("path")
            .datum(data)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-width", 1.5)
            .attr("d", line);

    }, [data]);


    return (
        <div ref={chartRef}></div>
    );
}