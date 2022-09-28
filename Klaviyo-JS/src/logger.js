export const loggerMiddleware = (apiName) => {
    return (_req, _res, next) => {
        console.log(`Executing /${apiName} request`);

        next();
    }
}
