import React, { useEffect, useState } from 'react'
import StatisticsService from '../services/statisticsService'
import { useSelector } from 'react-redux'
import {
    TableRow,
    TableHeaderCell,
    TableHeader,
    TableCell,
    TableBody,
    Table,
} from 'semantic-ui-react'

export default function Statistics() {
    const [statistic, setStatistic] = useState({})
    const customer = useSelector(state => state.customer);
    useEffect(() => {
        let statisticService = new StatisticsService()
        console.log(customer[0].customer_id)
        statisticService.getStatisticsByUser(customer[0].customer_id).then(result => setStatistic(result.data))
        console.log(statistic)
    }, [customer])

    function handleColorPositive() {

        return statistic.winrate >= 0.5 ? true : false;
    }
    function handleColorNegative() {

        return statistic.winrate < 0.5 ? true : false;
    }

    return (
        <div>
            <Table celled>
                <TableHeader>
                    <TableRow>
                        <TableHeaderCell>Total Loss</TableHeaderCell>
                        <TableHeaderCell>Total Earning</TableHeaderCell>
                        <TableHeaderCell sc>Winrate</TableHeaderCell>
                    </TableRow>
                </TableHeader>

                <TableBody>
                    <TableRow>
                        <TableCell negative>{statistic.total_loss}</TableCell>
                        <TableCell positive>{statistic.total_earning}</TableCell>
                        <TableCell negative={handleColorNegative()} positive={handleColorPositive()}>{statistic.winrate * 100 + " %"}</TableCell>
                    </TableRow>
                </TableBody>
            </Table>
        </div>
    )
}
