// 미들웨어 함수
export const loggerMiddleware = (store) => (next) => (action) => {
  console.log("store", store);
  console.log("action", action);
  next(action);
};
