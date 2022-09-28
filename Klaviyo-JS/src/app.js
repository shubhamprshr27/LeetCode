import express from 'express';
import { loggerMiddleware } from './logger.js';
import { parseTodoItems } from './items.js';
const app = express();

app.use(express.json());
const PORT = process.env.PORT || 8000;

app.get('/', (_req,res) => {
    return res.json({
        message : 'Hello World in Express'
    })
});

app.get('/greet', (req, res) => {
    const name = req.query?.name || 'Unknown';
    return res.json({
        message: `${name}, this will be an APi.`
    })
});

app.get('/todo', loggerMiddleware('todo'),(req, res) => {
    const todoItems = parseTodoItems(req);
    return res.json(todoItems);
})

app.listen(PORT, () => console.log(`Server started on port: ${PORT}`));