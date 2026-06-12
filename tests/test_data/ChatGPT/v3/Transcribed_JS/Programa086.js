const programa = {
  encontrarMinYMax: (a) => {
    let min = a[0];
    let max = a[0];
    for (const v of a) {
      if (v < min) min = v;
      if (v > max) max = v;
    }
    console.log(`Min=${min}, Max=${max}`);
  }
};

const a = [6, 12, 18, 4, 10];
programa.encontrarMinYMax(a);