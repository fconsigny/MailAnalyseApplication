import { Bar } from "react-chartjs-2";
import { Pie } from 'react-chartjs-2';

export const ChartBar = (props) => {
  const data = props.data
  const options = props.options

  return (
    <Bar data={data} options={options} />
  )
}

export const ChartPie = (props) => {
  const data = props.data
  const options = props.options

  return (
    <Pie data={data} options={options} />
  )
}

