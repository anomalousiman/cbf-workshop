export interface State {
  products: Product[]
}

export interface Product {
  id: number,
  name: string,
  description: string,
  images: string[]
}
