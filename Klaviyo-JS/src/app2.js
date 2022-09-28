import express from 'express';
/**
 * Some Important Syntax
 * 1) Object.keys(obj) -> returns array of keys.
 * 2) Object.values(obj) -> returns array of values.
 * 3) Object.entries(obj,val) -> array of keys and values.
 * 4) 
 */


const PORT = process.env.PORT || 3000;

const app = express();
app.use(express.json())

app.get('/', (_req, res) => {
  console.log('req was hit');
  res.json({ message: 'Hello World' });
})

app.get('/hello', (_req, res) => {
  console.log('req was hit');
  res.json({ message: 'Hello Shubham' });
})

app.listen(PORT, () => console.log('Server Was Started'));