  /* Sets the width of the sidebar to 250 */
  function openNav() {
    document.getElementById(
      "side_bar").style.width = "140px";
    // document.getElementById(
    //   "main").style.display = "none";
  }

  /* Set the width of the sidebar to 0 */
  function closeNav() {
    document.getElementById(
      "side_bar").style.width = "0";
    document.getElementById(
      "about_content_container").style.display = "block";
  }