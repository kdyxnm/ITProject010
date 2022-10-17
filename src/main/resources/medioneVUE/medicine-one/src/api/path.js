//const port = process.env.PORT || 8081

const base = {
  baseUrl       : 'http://localhost:8081',
  //baseUrl       : "https://medione.herokuapp.com",
  //baseUrl       : "https://medione-dev.herokuapp.com",
  login         : '/user/login',
  email         : '/mail/send',
  register      : '/user/register',
  resetPassword : '/user/reset',
  dashboard     : '/dashboard',

  pagination    : '/medicine/page',

  search        : '/medicine/search/',

  getMedicine   : '/medicine/',

  getNote       : '/medicine/note/',

  addNote       : '/medicine/note/',

  takeMedicine  : '/medicine/take/',

  deleteMedicine: '/medicine/',



  addLocation : '/location',
  delLocation : '/location',

  addMedicine : '/medicine',
  uploadImage : '/uploadImage',
  delMedicine : '',
  
}

export default base;
