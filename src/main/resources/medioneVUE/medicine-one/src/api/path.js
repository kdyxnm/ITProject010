const port = process.env.PORT || 8081

const base = {
  baseUrl     : 'http://localhost:' + port,
  //baseUrl     : "https://medione.herokuapp.com",
  login       : '/user/login',
  email       : '/mail/send',
  register    : '/user/register',
  dashboard   : '/dashboard',

  pagination  : '/medicine/page',

  search      : '/medicine/search/',

  getMedicine : '/medicine/',


  addLocation : '',
  delLocation : '',

  addMedicine : '',
  delMedicine : '',
  modMedicine : '',
  
  serch : ''
}

export default base;
