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

// Source - https://stackoverflow.com/a/50012963
// Posted by Vic, modified by community. See post 'Timeline' for change history
// Retrieved 2026-10-19, License - CC BY-SA 4.0

