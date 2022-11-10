// Encapsulation of back end API request path
const base = {
  // baseUrl       : 'http://localhost:8081',
  baseUrl       : "https://medione.herokuapp.com",
  //baseUrl       : "https://medione-dev.herokuapp.com",
  login         : '/user/login',
  email         : '/mail/send',
  register      : '/user/register',
  resetPassword : '/user/reset',
  dashboard     : '/dashboard',

  pagination    : '/medicine/page',

  search        : '/medicine/search/',

  getMedicine   : '/medicine/detail/',

  getNote       : '/medicine/note/',

  addNote       : '/medicine/note/',

  takeMedicine  : '/medicine/take/',

  deleteMedicine: '/medicine/',



  addLocation : '/location',
  delLocation : '/location',

  addMedicine : '/medicine',
  uploadImage : '/uploadImage2',
  delMedicine : '',
  
}

export default base;
