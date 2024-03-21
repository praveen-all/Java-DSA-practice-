import PIL
from PIL import Image,ImageFilter
img=Image.open("download.jpg")
#img.show()
si=(1000,1000)
img1=img.resize(si)
img2=img1.rotate(35,expand=1)
b,r,g=img2.split()
# r.show()
# g.show()
# b.show()
img3=Image.merge("RGB",(g,r,b))
img4=img3.filter(ImageFilter.SMOOTH)
img5=img4.filter(ImageFilter.FIND_EDGES)
img6=img5.filter(ImageFilter.BLUR)

img6.show()
