FROM ghcr.io/graalvm/graalvm-community:21 AS base

RUN microdnf install -y python3 python3-pip && microdnf clean all

WORKDIR /app

COPY requirements.txt .

RUN pip3 install --no-cache-dir -r requirements.txt

COPY . .

EXPOSE 8000

CMD ["uvicorn", "api.main:app", "--host", "0.0.0.0", "--port", "8000"]