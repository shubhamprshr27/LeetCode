import { todoItems } from "./mockData.js";

export const parseTodoItems = (req) => {
    const operation = req.query?.operation;
    let response = { mappedItems:{} };
    if (operation === 'reduce'){
        response.mappedItems = todoItems.items.reduce((obj, item, itemIdx) => {
            let { id, title } = item;
            return {...obj, [id]: {title, itemIdx}};
        }, {})
    }
    else if (operation === 'foreach') {
        todoItems.items.forEach((item) => item.newField = 'newField');
        response.mappedItems = todoItems;
    }
    else if (operation === 'map') {
        todoItems.items.map(item => item.userId);
    }
    return response;
}