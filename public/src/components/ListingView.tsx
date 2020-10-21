import React from 'react';
import { Link } from 'react-router-dom'
import styled from 'styled-components'

import { Product } from '../state'

const Container = styled.div`
  border: 8px solid #000;
  margin-top: 24px;
  margin-left: 30%;
  margin-right: 30%;
  width: 40%;
  height: 100%;

  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
`

const Item = styled.div`
  border: 8px solid #000;
  margin: 16px;
  padding: 8px;
  padding: 8px;
  width: calc((100% / 3) - (8 * 8px));
`

const Title = styled(Link)`
  font-weight: 700px;
  color: #000;
  font-size: 32px;
  text-decoration: none;
`

const Thumbnail = styled.img`
  width: calc(100% - 16px);
  border-top: 8px solid #000;
  padding-top: 8px;
  margin-left: 8px;
  margin-right: 8px;
  margin-bottom: 8px;
`

export interface ListingViewProps {
  products: Product[]
}

export const ListingView = ({products}: ListingViewProps) => (
  <Container>
    {
      products.map((product, key) =>
      <Item>
        <Title to={"/product/"+key}>{product.name}</Title>
        
        {
          product.images[0] ? (
            <Thumbnail src={product.images[0]} />
          ) : (<></>)
        }

      </Item>
      )
    }
  </Container>
);
