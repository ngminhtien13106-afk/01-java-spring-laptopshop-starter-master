const elementDelete = document.querySelector(".btn-on-click-d");
const elementCreate = document.querySelector(".btn-on-click-c");
const elementUpdate = document.querySelector(".btn-on-click-u");

if (elementCreate) {
  elementCreate.addEventListener("click", (e) => {
    const result = confirm("Bạn có muốn thêm mới ?");

    if (!result) {
      e.preventDefault();
    }
  });
}

if (elementDelete) {
  elementDelete.addEventListener("click", (e) => {
    const result = confirm("Bạn có muốn xoá?");

    if (!result) {
      e.preventDefault();
    }
  });
}

if (elementUpdate) {
  elementUpdate.addEventListener("click", (e) => {
    const result = confirm("Bạn có muốn cập nhật thông tin ?");

    if (!result) {
      e.preventDefault();
    }
  });
}