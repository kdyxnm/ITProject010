componentDidMount(){
  this.rem()
}

rem = () => {  //改变根节点的
  (() => {
    let that = this
    function computed() {
      let HTML = document.documentElement;
      let winW = HTML.clientWidth;
      HTML.style.fontSize = `${(winW / 1366) * 16}px`;
      console.log(HTML.style.fontSize, that.props.changeFontSize(HTML.style.fontSize))
    //把改变后的根节点大小传出去，也可以存在 redux 中，比如 Echarts 就需要判断是否需要重绘
      that.props.changeFontSize(HTML.style.fontSize)
    }
    computed();
    window.addEventListener('resize', computed, false);
  })();
}