import React from 'react';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'
import styled from 'styled-components'

import config from '../config.json';
import { Product } from '../state'

const Container = styled.div`
  border: 8px solid #000;
  margin-top: 24px;
  margin-left: 30%;
  margin-right: 30%;
  padding: 24px;
  width: 40%;
  height: 100%;

  display: flex;
  flex-direction: column;
`

const Title = styled.div`
  font-size: 32px;
  padding-top: 8px;
  padding-bottom: 24px;
`
const Description = styled.div`
  font-size: 24px;
  padding-top: 16px;
  padding-bottom: 24px;
  border-top: 8px solid #000;

`

const Thumbnail = styled.img`
  width: calc(100% - 16px);
  border-top: 8px solid #000;
  padding: 8px;
`

export const ProductView = () => {
  let { id } = useParams();

  const [ product, setProduct ] = useState<Product>()

  useEffect(() => {
    fetch(config.apiBaseUri + "/product/" + id)
      .then(response => response.json())
      .then(response => setProduct(response))
      .catch(console.log)
  }, [JSON.stringify(product)])

  return product ? (
    <Container>
      <Title>{product.name}</Title>
      <Description>{product.description}</Description>
        
      {
        product.images.map(image => (
          <Thumbnail src={product.images[0]} />
        ))
      }
    </Container>
  ) : <></>;
}
